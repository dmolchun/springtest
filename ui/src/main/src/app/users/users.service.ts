import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from "./user";
import { Observable } from "rxjs/Observable";
import { of } from 'rxjs/observable/of';

@Injectable()
export class UsersService {

  private usersUrl = 'app/user/users';

  constructor(private http:HttpClient) {
  }

  getUsers():Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }
}
