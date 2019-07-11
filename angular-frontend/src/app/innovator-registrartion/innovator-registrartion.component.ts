import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FormControl} from '@angular/forms';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'app-innovator-registrartion',
  templateUrl: './innovator-registrartion.component.html',
  styleUrls: ['./innovator-registrartion.component.css']
})
export class InnovatorRegistrartionComponent implements OnInit {
  Domain = new FormControl();
  domainList: string[] = ['IT', 'TOURISM'];
  subdomain = new FormControl();
 
  skills = new FormControl();
  skillsList: string[] = ['c','java','python'];
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  isOptional = true;
  subdomainList: string[] = [ 'developer', 'Testing',];
 skillList: string[] = [ 'c', 'java',];

 form: any = {};

errorMessage = '';
pass:string='';
conf:string;
  LoginService: any;



  constructor(private _formBuilder: FormBuilder,private dialog:MatDialog) { }
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
      NumberCtrl: ['', Validators.required],
      domainCtrl: ['', Validators.required],
        subdomainCtrl: ['', Validators.required],
        SkillsCtrl: ['', Validators.required],
       
      secondCtrl: ['', Validators.required]
    });
    this.thirdFormGroup = this._formBuilder.group({
      AboutCtrl: ['', Validators.required],
      secCtrl: ['', Validators.required],

     });
  
  this.secondFormGroup = this._formBuilder.group({
    email:['',Validators.email],
    password:['',Validators.minLength(8)],
   
     
    
     

  });
  this.thirdFormGroup = this._formBuilder.group({
    subdomain:[''],
    skill:['']
  });
}

  onSubmit()
  {

    this.pass= this.secondFormGroup.controls.password.value;
    this.conf= this.secondFormGroup.controls.confirm.value;
  }
 
 register():void {
   console.log(this.form);

 
}
}