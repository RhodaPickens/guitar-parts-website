package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        if(outsourcedPartRepository.count()==0) {

            OutsourcedPart bridge = new OutsourcedPart();
            bridge.setCompanyName("G&W");
            bridge.setName("Bridge");
            bridge.setInv(5);
            bridge.setMinInv(1);
            bridge.setMaxInv(50);
            bridge.setPrice(27.99);
            bridge.setId(200);
            outsourcedPartRepository.save(bridge);

            OutsourcedPart pickguard = new OutsourcedPart();
            pickguard.setCompanyName("AllParts");
            pickguard.setName("Pickguard");
            pickguard.setInv(3);
            pickguard.setMinInv(1);
            pickguard.setMaxInv(50);
            pickguard.setPrice(3.00);
            pickguard.setId(201);
            outsourcedPartRepository.save(pickguard);

            OutsourcedPart boneSaddle = new OutsourcedPart();
            boneSaddle.setCompanyName("Gibson");
            boneSaddle.setName("Bone Saddle");
            boneSaddle.setInv(10);
            boneSaddle.setMinInv(1);
            boneSaddle.setMaxInv(50);
            boneSaddle.setPrice(6.99);
            boneSaddle.setId(202);
            outsourcedPartRepository.save(boneSaddle);

            OutsourcedPart bridgePins = new OutsourcedPart();
            bridgePins.setCompanyName("Allparts");
            bridgePins.setName("Bridge Pins");
            bridgePins.setInv(5);
            bridgePins.setMinInv(1);
            bridgePins.setMaxInv(50);
            bridgePins.setPrice(12.99);
            bridgePins.setId(203);
            outsourcedPartRepository.save(bridgePins);

            OutsourcedPart pickup = new OutsourcedPart();
            pickup.setCompanyName("Fishman");
            pickup.setName("Pickup");
            pickup.setInv(2);
            pickup.setMinInv(1);
            pickup.setMaxInv(50);
            pickup.setPrice(150.00);
            pickup.setId(204);
            outsourcedPartRepository.save(pickup);

        }

        /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        if(productRepository.count()==0) {

            // Creating objects from the product class
            Product martin = new Product("Martin Acoustic Guitar", 599.0, 15);
            Product taylor = new Product("Taylor Acoustic-Electric Guitar", 799.0, 10);
            Product fender = new Product("Fender Acoustic-Electric Guitar", 349.0, 5);
            Product yamaha = new Product("Yamaha F335 Acoustic-Electric Guitar", 199.0, 20);
            Product ibanez = new Product("Ibanez Auditorium Acoustic-Electric Guitar", 329.99, 3);

            productRepository.save(martin);
            productRepository.save(taylor);
            productRepository.save(fender);
            productRepository.save(yamaha);
            productRepository.save(ibanez);

        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
