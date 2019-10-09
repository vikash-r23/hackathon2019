import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class IdeasService {

  private _mockIdeaServiceURL = './assets/mockData/ideaData.json';
  private _createIdeaURL = 'http://localhost:8181/api/idea/pitch';
  constructor(private _httpCall: HttpClient) { }

  getIdeasData(): Observable<any> {
    return this._httpCall.get<any>(this._mockIdeaServiceURL);
  }

  createIdea(newIdea:Object): Observable<Object> {
    this._httpCall.post(this._createIdeaURL,newIdea).subscribe(data => console.log(data));
    return this._httpCall.post(this._createIdeaURL,newIdea, {headers: new HttpHeaders({"content-type": "application/json", "Authorisation" : "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0MUBnbWFpbC5jb20iLCJleHAiOjE1NzA2NDg0MDAsImlhdCI6MTU3MDYzMDQwMH0.uM4Zg5jbU1UHmMZaKBuK2jCAFl7KUi-gqXZG4ISKtr-jf3wIF15EqFuXSncAderST8NJo3AXW5X-twMutI9_ig"})});

      
  }
}
