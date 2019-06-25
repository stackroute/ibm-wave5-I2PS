import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-serice-provider',
  templateUrl: './serice-provider.component.html',
  styleUrls: ['./serice-provider.component.css']
})
export class SericeProviderComponent implements OnInit {

  constructor(private registrationService:RegistrationService,private router:Router) { }
 
  serviceProviderData:any=[];
  skills = [];
  certifications=[];
  subDomains=[];

  ngOnInit() {

    this.registrationService.getServiceProvider().subscribe(data=>
      {
        console.log(data);
        this.serviceProviderData=data;
      });
  }

  register(emailId,password,name,domain,subDomains,role,skills,about,experience,chargePerHour,certifications)
  {
    console.log(emailId, password,name,domain,subDomains,role,skills,about,experience,chargePerHour,certifications);
     let providerdata={  
      emailId:emailId,
       password:password,
       name:name,
       domain:domain,
       subDomain:this.subDomains,
       role:role,
       skills:this.skills,
       about:about,
       experience:experience,
       chargePerHour:chargePerHour,
       certifications:this.certifications
     
  }
  console.log("hiiiiiii",providerdata);
   this.registrationService.addServiceProvider(providerdata);
  //  console.log("hi");
}

addSkill(skill) {
  this.skills.push(skill)  
}
addCertificate(certificate) {
  this.certifications.push(certificate);  
}
addsubDomain(subDomain) {
  this.subDomains.push(subDomain)  
}

}