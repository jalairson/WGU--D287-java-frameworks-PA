package com.example.demo.bootstrap;

import com.example.demo.domain.Product;
import com.example.demo.domain.InhousePart;
import com.example.demo.repositories.*;
import com.example.demo.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    private PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository=inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        PartService partService = context.getBean(PartServiceImpl.class);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

        InhousePart part1 = new InhousePart();
            part1.setId(111);
            part1.setName("storage");
            part1.setPrice(100.0);
            part1.setInv(15);
            part1.setMinInv(10);
            part1.setMaxInv(100);
            inhousePartRepository.save(part1);

        InhousePart part2 = new InhousePart();
            part2.setId(222);
            part2.setName("memory");
            part2.setPrice(100.0);
            part2.setInv(15);
            part2.setMinInv(10);
            part2.setMaxInv(100);
            inhousePartRepository.save(part2);

        InhousePart part3 = new InhousePart();
            part3.setId(333);
            part3.setName("gpu");
            part3.setPrice(100.0);
            part3.setInv(15);
            part3.setMinInv(10);
            part3.setMaxInv(100);
            inhousePartRepository.save(part3);

        InhousePart part4 = new InhousePart();
            part4.setId(444);
            part4.setName("cpu");
            part4.setPrice(100.0);
            part4.setInv(15);
            part4.setMinInv(10);
            part4.setMaxInv(100);
            inhousePartRepository.save(part4);

        InhousePart part5 = new InhousePart();
            part5.setId(555);
            part5.setName("motherboard");
            part5.setPrice(100.0);
            part5.setInv(15);
            part5.setMinInv(10);
            part5.setMaxInv(100);
            inhousePartRepository.save(part5);

        System.out.println("Number of Parts after adding new parts: " + partRepository.count());
        System.out.println(partRepository.findAll());

        Product product1 = new Product("pc 1", 700.0, 5);
        productRepository.save(product1);

        Product product2 = new Product("pc 2", 600.0, 5);
        productRepository.save(product2);

        Product product3 = new Product("pc 3", 750.0, 5);
        productRepository.save(product3);

        Product product4 = new Product("pc 4", 900.0, 5);
        productRepository.save(product4);

        Product product5 = new Product("pc 5", 1000.0, 1);
        productRepository.save(product5);

        System.out.println("Number of Products after adding new products: " + productRepository.count());
        System.out.println(productRepository.findAll());

        }

    }
