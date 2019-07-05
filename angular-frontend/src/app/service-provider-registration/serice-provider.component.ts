import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';
import subdomain from 'src/assets/jsonfiles/data2.json';
import skills from 'src/assets/jsonfiles/data4.json';


@Component({
  selector: 'app-serice-provider',
  templateUrl: './serice-provider.component.html',
  styleUrls: ['./serice-provider.component.css']
})
export class SericeProviderComponent implements OnInit {

  constructor(private registrationService:RegistrationService,private router:Router) {
    // console.log("coming");
    // console.log(subdomain.id,subdomain.domain,subdomain.subDomain)

   }
 
  serviceProviderData:any=[];
  skills = [];
  certifications=[];
  subDomains=[];
  subDomainList:any=subdomain;
  skillsList:any=skills;
  ngOnInit() {


    this.registrationService.getServiceProvider().subscribe(data=>
      {
        console.log(data);
        this.serviceProviderData=data;
      });
  }

  onClick(value)
  {
    console.log(value);
    this.subDomains=value;
  }

  onClickSkills(value)
  {
    console.log(value);
    this.skills=value;
  }
  

  register(emailId,password,name,domain,subDomains,role,skills,about,chargePerHour)
  {
    
    console.log(emailId, password,name,domain,subDomains,role,skills,about,chargePerHour);
     let providerdata={  
      emailId:emailId,
       password:password,
       name:name,
       domain:domain,
       subDomain:this.subDomains,
       role:role,
       skills:this.skills,
       about:about,
       chargePerHour:chargePerHour
       
       
     
  }
  console.log("hiiiiiii",providerdata);
   this.registrationService.addServiceProvider(providerdata);
  //  console.log("hi");
  this.router.navigateByUrl("/landingpage");
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