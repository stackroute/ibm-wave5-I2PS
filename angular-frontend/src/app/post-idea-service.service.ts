import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostIdeaServiceService {

  constructor(private httpclient: HttpClient) { }

  postIdea(value): any{
    console.log("in service of post idea "+value);
    return this.httpclient.post("http://localhost:8063/api/v1/addIdea",value).subscribe();
    
  }
}
