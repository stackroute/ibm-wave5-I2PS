import { Component, OnInit } from '@angular/core';
import { IntelligentserviceService } from '../intelligentservice.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-intelligent-service',
  templateUrl: './intelligent-service.component.html',
  styleUrls: ['./intelligent-service.component.scss']
})
export class IntelligentServiceComponent implements OnInit {

  constructor(private intelligentService: IntelligentserviceService, private route: ActivatedRoute,
    private router: Router) { }
  arrayOfServiceProviders: any = [];
  servProvider: any;
  acceptedServiceProvoders: any = [];
  rejectedServiceProviders: any = [];
  length: any;
  roles: string[] = [];;

  ngOnInit() {
    this.getAllServiceProviders();
  }




  getAllServiceProviders() {
    const sp= this.route.snapshot.paramMap.get('roles');
  
     var arrayOfroles = sp.split(',');

    //  console.log("hi",arrayOfroles)

     
     arrayOfroles.forEach(element => {
      
  
    this.intelligentService.getServiceProviders(element).subscribe(data => {

      console.log("all service providers are",data)

       data.serviceProvider.map(e => {
        this.arrayOfServiceProviders.push(e)
      });

   
      length = this.arrayOfServiceProviders.length;
    
      this.servProvider = this.arrayOfServiceProviders[length - 1];
    
   
    });

  });

  
  }



  public accept() {
    length = this.arrayOfServiceProviders.length;

    this.servProvider = this.arrayOfServiceProviders[length - 1];
    this.acceptedServiceProvoders.push(this.servProvider);
    this.arrayOfServiceProviders.pop(this.servProvider);
    console.log("arrayofserviceproviders", this.arrayOfServiceProviders, "acceptedprovoders", this.acceptedServiceProvoders)




  }

  public reject() {
    length = this.arrayOfServiceProviders.length;

    this.servProvider = this.arrayOfServiceProviders[length - 1];
    this.arrayOfServiceProviders.pop(this.servProvider)
    console.log("remaining service providers are",this.arrayOfServiceProviders);
  }




}
