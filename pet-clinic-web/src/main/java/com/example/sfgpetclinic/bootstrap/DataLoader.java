package com.example.sfgpetclinic.bootstrap;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.Pet;
import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.PetTypeService;
import com.example.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Micahel");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickers");
        owner1.setCity("Maiami");
        owner1.setTelephone("12345423435");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("543 Brooklen");
        owner2.setCity("New York");
        owner2.setTelephone("6543124213");

        Pet fionascat = new Pet();
        fionascat.setPetType(savedCatPetType);
        fionascat.setOwner(owner2);
        fionascat.setBirthDate(LocalDate.now());
        fionascat.setName("Just Cat");
        owner2.getPets().add(fionascat);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Micahel3");
        owner3.setLastName("Weston3");
        owner3.setAddress("234 Oklahoma");
        owner3.setCity("Oklahoma");
        owner3.setTelephone("2453656565");
        ownerService.save(owner3);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Jasse");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Laoded Vets......");

    }
}
