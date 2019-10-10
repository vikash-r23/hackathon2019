import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private _mockAdminTotalServiceURL = './assets/mockData/adminData.json';
  private _mockAdminSingleServiceURL = './assets/mockData/adminData.json';
  private _mockAdminDropDownServiceURL = './assets/mockData/adminDropDownData.json';

  constructor(private _httpCall: HttpClient) { }

  getAdminTotalData(): Observable<any> {
    return this._httpCall.get<any>(this._mockAdminTotalServiceURL);
  }

  getAdminSingleData(userId:any): Observable<any> {
    return this._httpCall.get<any>(this._mockAdminSingleServiceURL);
  }

  getAdminDropDownData(): Observable<any> {
    return this._httpCall.get<any>(this._mockAdminDropDownServiceURL);
  }
}
