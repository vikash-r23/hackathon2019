import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SignInService {

  constructor(private _httpCall: HttpClient) { }
  public userDetails;
  
  authenticateUser(body: any): Observable<any> {
    
    return this._httpCall.post(environment.apiUrl+"/api/user/authenticate", body);
    
  }
}
