import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {MatTableModule, MatTabsModule} from '@angular/material';
import {NgModule} from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
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


const appRoutes: Routes = [
  {path: '', redirectTo: '/main', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'ui/users', component: UsersComponent},
  {path: 'main', component: MainComponent}
];

@NgModule({
  exports: [
    MatTableModule,
    MatTabsModule
  ]
})
export class MaterialComponentsModule {
}

@NgModule({
  declarations: [
    AboutComponent,
    AppComponent,
    LoginComponent,
    MainComponent,
    MoviesComponent,
    UsersComponent,
    UsersGridComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    MaterialComponentsModule,
    NgbModule.forRoot(),
    NoopAnimationsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    HttpClientModule,
    LoginService,
    UsersService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
