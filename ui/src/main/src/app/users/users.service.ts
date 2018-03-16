import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from "./user";
import {Observable} from "rxjs/Observable";

@Injectable()
export class UsersService {

  private usersUrl = 'app/user/users';
  private usersByIdUrl = 'app/user/id/';
  private rolesUrl = 'app/user/roles';
  private currentUserUrl = 'app/user/info';
  private saveUserUrl = 'app/user/save';

  constructor(private http: HttpClient) {
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  getRoles(): Observable<string[]> {
    return this.http.get<string[]>(this.rolesUrl);
  }

  getCurrentUser(): Observable<User> {
    return this.http.get<User>(this.currentUserUrl);
  }

  getUser(id: number): Observable<User> {
    return this.http.get<User>(this.usersByIdUrl + id);
  }

  saveUser(user: User): Observable<Object> {
    return this.http.post(this.saveUserUrl, user)
  }
}
