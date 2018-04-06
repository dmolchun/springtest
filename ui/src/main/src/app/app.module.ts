import {BrowserModule} from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {
  MatButtonModule, MatCheckboxModule, MatDialogModule, MatIconModule, MatInputModule, MatSelectModule, MatSnackBarModule,
  MatTableModule, MatTabsModule
} from '@angular/material';
import {MatFormFieldModule} from '@angular/material/form-field'
import {NgModule} from '@angular/core';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {RouterModule, Routes} from '@angular/router';


import {AboutComponent} from './about/about.component';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {MainComponent} from './main/main.component';
import {MoviesComponent} from './movies/movies.component';
import {UsersComponent} from './users/users.component';
import {UsersGridComponent} from './users/users-grid/users-grid.component';
import {UsersService} from "./users/users.service";
import {LoginService} from "./login/login.service";
import {UserCardComponent} from './users/user-card/user-card.component';
import {DtDirective} from "./users/dt.directive";
import { UserPasswordChangeComponent } from './users/user-password-change/user-password-change.component';


const appRoutes: Routes = [
  {path: '', redirectTo: '/main', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'ui/users', component: UsersComponent},
  {path: 'ui/users/user/:id', component: UserCardComponent},
  {path: 'main', component: MainComponent}
];
const modules = [
  MatButtonModule,
  MatCheckboxModule,
  MatDialogModule,
  MatIconModule,
  MatInputModule,
  MatSelectModule,
  MatSnackBarModule,
  MatTableModule,
  MatTabsModule,
  MatFormFieldModule
];

@NgModule({
  exports: [
    modules
  ],
  declarations: [
    AboutComponent,
    AppComponent,
    DtDirective,
    LoginComponent,
    MainComponent,
    MoviesComponent,
    UserCardComponent,
    UsersComponent,
    UsersGridComponent,
    UserPasswordChangeComponent
  ],
  imports: [
    modules,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NoopAnimationsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    HttpClientModule,
    LoginService,
    UsersService
  ],
  entryComponents: [UserPasswordChangeComponent],
  bootstrap: [AppComponent]
})
export class AppModule {
}
