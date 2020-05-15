import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";
import { SignInService } from './sign-in.service';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class IdeasService {

  private _mockIdeaServiceURL = './assets/mockData/ideaData.json';
  private _createIdeaURL = 'http://griiin.southindia.cloudapp.azure.com:8080/api/idea/pitch';
  constructor(private _httpCall: HttpClient) { }

  getIdeasData(userDetails): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': "Bearer " + userDetails['jwttoken']
      })
    };
    return this._httpCall.get<any>(environment.apiUrl+"/api/idea/allIdeas", httpOptions);
  }

  createIdea(newIdea:Object, token:String): Observable<Object> {
    // console.log(this.signinService.userDetails)
    // this._httpCall.post(this._createIdeaURL,newIdea).subscribe(data => console.log(data));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': "Bearer " + token
      })
    };
    return this._httpCall.post(environment.apiUrl+"/api/idea/pitch",newIdea, httpOptions);

      
  }
}
