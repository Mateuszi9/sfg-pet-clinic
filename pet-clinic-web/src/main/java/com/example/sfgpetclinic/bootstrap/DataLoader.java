package com.example.sfgpetclinic.bootstrap;

import com.example.sfgpetclinic.model.*;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.PetTypeService;
import com.example.sfgpetclinic.services.SpecialtyService;
import com.example.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0)
        {
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality saveSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDentistry = specialtyService.save(dentistry);


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
        vet1.getSpecialities().add(saveRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jasse");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(saveSurgery);

        vetService.save(vet2);

        System.out.println("Laoded Vets......");
    }
}
