import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class SignInService {

  constructor(private _httpCall: HttpClient) { }
  public userDetails;
  
  authenticateUser(body: any): Observable<any> {
    
    return this._httpCall.post("http://griiin.southindia.cloudapp.azure.com:8080/api/user/authenticate", body);
    
  }
}
