import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router'; 
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { routes } from './app.routes';
import { CreateUserComponent } from './create-user/create-user.component';
import { FormsModule } from '@angular/forms'

@NgModule({
  declarations: [AppComponent, UserListComponent, CreateUserComponent],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
