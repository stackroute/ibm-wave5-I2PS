import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';

import { MatDialog } from '@angular/material';

import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { LoginService } from '../login.service';
import subdomain from 'src/assets/jsonfiles/data2.json';
import skills from 'src/assets/jsonfiles/data4.json';

@Component({
  selector: 'app-service-provider-registration',
  templateUrl: './service-provider-registration.component.html',
  styleUrls: ['./service-provider-registration.component.css']
})
export class ServiceProviderRegistrationComponent implements OnInit {

  Domain = new FormControl();
  domainList: string[] = ['IT', 'TOURISM'];
  subdomain = new FormControl();
 
  skills = new FormControl();
  skillsList: any=skills;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  isOptional = true;
  subDomainList: any=subdomain;


form: any = {};

errorMessage = '';
pass:string='';
conf:string;
  LoginService: any;



  constructor(private _formBuilder: FormBuilder,private Userloginservice: LoginService,private dialog:MatDialog) { }
  getErrorFnameMessage(){
    // return this.firstFormGroup.controls.FirstName.hasError('required') ? 'You must enter a value':'';
  }
 
  getpassErrorMessage(){
    //return this.password.hasError('required') ? 'You must enter a value': '';
  }
 
  getconfirmErrorMessage(){
  //  if(this.password.value!=this.confirm.value) {
  //  return "Password Not Matching";
   // }
  }

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      FirstName: ['', Validators.required],
      LastName: ['', Validators.required]
  
  
    });
    this.secondFormGroup = this._formBuilder.group({
      email:['',Validators.email],
      password:['',Validators.minLength(8)],
      domainCtrl: ['', Validators.required]
     
       
      
       
 
    });
    this.thirdFormGroup = this._formBuilder.group({
      subdomain:[''],
      skill:['']
    });
  }
  onSubmit(){

    this.pass= this.secondFormGroup.controls.password.value;
    this.conf= this.secondFormGroup.controls.confirm.value;
  }
 
  register(name,emailId,password,domain,subDomain,skills,role,charge)
  {
    
  }
  



}



