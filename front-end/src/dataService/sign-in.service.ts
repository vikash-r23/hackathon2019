import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class SignInService {

  constructor(private _httpCall: HttpClient) { }

  authenticateUser(body: any): Observable<any> {
    return this._httpCall.post("http://localhost:8181/api/user/authenticate", body);
  }
}
