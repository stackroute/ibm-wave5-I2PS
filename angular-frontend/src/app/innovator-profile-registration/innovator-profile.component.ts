import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-innovator-profile',
  templateUrl: './innovator-profile.component.html',
  styleUrls: ['./innovator-profile.component.css']
})
export class InnovatorProfileComponent implements OnInit {

  constructor(private registrationService:RegistrationService,private router:Router) { }
 
  innovatorProfileData:any=[];
  
  subDomains=[];
subDomainList=['jsdkj','JHSDd','ghdsd'];
  ngOnInit() {

    this.registrationService.getInnovatorProfile().subscribe(data=>
      {
        console.log(data);
        this.innovatorProfileData=data;
      });
  }

  onClick(value){
    console.log(value);
    this.subDomains=value;
  }
  register(emailId,password,name,domain,subDomains)
  {
    console.log(emailId, password,name,domain,subDomains);
     let providerdata={  
      emailId:emailId,
       password:password,
       name:name,
       domain:domain,
       subDomain:this.subDomains,
       
     
  }
  console.log("hiiiiiii",providerdata);
   this.registrationService.addInnovatorProfile(providerdata);
  //  console.log("hi");

  this.router.navigateByUrl("/landingpage");
}


addsubDomain(subDomain) {
  this.subDomains.push(subDomain)  
}

}
