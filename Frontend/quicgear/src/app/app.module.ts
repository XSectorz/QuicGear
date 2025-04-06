import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router'; 
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { routes } from './app.routes';
import { CreateUserComponent } from './create-user/create-user.component';
import { LoginComponent } from './login/login.component';
import { ContentComponent } from './content/content.component';
import { FormsModule } from '@angular/forms'
import { CarouselModule } from 'ngx-owl-carousel-o';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [AppComponent, UserListComponent, CreateUserComponent,LoginComponent,ContentComponent],
  imports: [BrowserModule, FormsModule, CarouselModule,BrowserAnimationsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
