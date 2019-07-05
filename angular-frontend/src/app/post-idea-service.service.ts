import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostIdeaServiceService {

  constructor(private httpclient: HttpClient) { }

  postIdea(value): any{
    return this.httpclient.post("http://localhost:8087/api/v1/addIdea",value).subscribe();
      }
}
