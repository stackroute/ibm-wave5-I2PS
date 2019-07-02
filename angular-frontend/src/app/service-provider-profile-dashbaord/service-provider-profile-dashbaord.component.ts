import { Component, OnInit } from '@angular/core';

import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-service-provider-profile-dashbaord',
  templateUrl: './service-provider-profile-dashbaord.component.html',
  styleUrls: ['./service-provider-profile-dashbaord.component.css']
})
export class ServiceProviderProfileDashbaordComponent implements OnInit {

  constructor(private registrationService:RegistrationService,private router:Router) { }



  serviceProviderData:any=[];
  skills = [];
  certifications=[];
  subDomains=[];
  ngOnInit() {

    this.registrationService.getServiceProvider().subscribe(data=>
      {
        console.log("hiiiiiii",data);
        this.serviceProviderData=data;
        console.log("hmmm",this.serviceProviderData[0].emailId)
      });
  }
  

}
