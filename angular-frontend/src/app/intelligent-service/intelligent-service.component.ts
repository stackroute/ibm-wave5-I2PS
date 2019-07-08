import { Component, OnInit } from '@angular/core';
import { IntelligentserviceService } from '../intelligentservice.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-intelligent-service',
  templateUrl: './intelligent-service.component.html',
  styleUrls: ['./intelligent-service.component.css']
})
export class IntelligentServiceComponent implements OnInit {

  constructor(private intelligentService: IntelligentserviceService, private route: ActivatedRoute,
    private router: Router) { }
  arrayOfServiceProviders: any = [];
  servProvider: any;
  acceptedServiceProvoders: any = [];
  rejectedServiceProviders: any = [];
  length: any;

  ngOnInit() {
    this.getServiceProviders();
  }
  getServiceProviders() {
    const sp = this.route.snapshot.paramMap.get('role');
    // console.log("we are getting roles",sp)
    this.intelligentService.getServiceProviders(sp).subscribe(data => {

      this.arrayOfServiceProviders = data.serviceProvider;
      length = this.arrayOfServiceProviders.length;
    
      this.servProvider = this.arrayOfServiceProviders[length - 1];
    
    });
  }



  public accept() {
    length = this.arrayOfServiceProviders.length;

    this.servProvider = this.arrayOfServiceProviders[length - 2];
    this.acceptedServiceProvoders.push(this.servProvider);
    this.arrayOfServiceProviders.pop(this.servProvider);
    console.log("arrayofserviceproviders", this.arrayOfServiceProviders, "acceptedprovoders", this.acceptedServiceProvoders)




  }

  public reject() {
    this.arrayOfServiceProviders.pop(this.servProvider)
    // console.log("remaining service providers are",this.arrayOfServiceProviders);
  }
}








