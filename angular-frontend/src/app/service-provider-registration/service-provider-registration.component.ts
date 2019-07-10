import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationServiceService } from '../registration-service.service';
import subdomain from 'src/assets/jsonfiles/data2.json';
import skills from 'src/assets/jsonfiles/data4.json';

@Component({
  selector: 'app-service-provider-registration',
  templateUrl: './service-provider-registration.component.html',
  styleUrls: ['./service-provider-registration.component.scss']
})
export class ServiceProviderRegistrationComponent implements OnInit {

  constructor(private registrationService:RegistrationServiceService,private router:Router) {
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
  

  register(emailId,password,name,role,domain,subDomains,skills,about,chargePerHour)
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
