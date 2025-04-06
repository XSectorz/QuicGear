import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';
import { LoginComponent } from '../login/login.component';
import { CommonModule } from '@angular/common';
import { User } from '../model/user';
import { StateService } from '../state.service';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { ProductListComponent } from '../product-list/product-list.component';

@Component({
  selector: 'app-content',
  imports: [LoginComponent,CommonModule,CarouselModule,ProductListComponent],
  templateUrl: './content.component.html',
  styleUrl: './content.component.css'
})
export class ContentComponent {

  constructor(private axiosService: AxiosService, public appStateService: StateService) {}

  user!: User;

  showComponent(componentToShow: string): void {
    this.appStateService.setComponentToShow(componentToShow);
  }

  carouselImages: string[] = [
    'banner-1.jpg',
    'banner-2.jpg',
    'banner-3.jpg'
  ];
  
  carouselOptions: any = {
    loop: true,
    mouseDrag: true,
    touchDrag: true,
    pullDrag: true,
    dots: false,
    navSpeed: 1000,  
    navText: ['', ''],
    responsive: {
      0: {
        items: 1
      },
      400: {
        items: 1
      },
      740: {
        items: 1
      },
      940: {
        items: 1
      }
    },
    nav: false,
    autoplay: true,          
    autoplayTimeout: 5000,  
    autoplaySpeed: 1000,
    autoHeight: false
  };

  onLogin(input: any): void {
    this.axiosService.request(
      "POST",
      "/login",
      {
        username: input.username,
        password: input.password
      }
    ).then(response => {

      this.user = {
        id: response.data.id,
        username: response.data.username,
        balance: response.data.balance,
        userRole: response.data.userRole,
        email: response.data.email
      }

      this.axiosService.setAuthToken(response.data.token);
      this.showComponent("main");
    })
  }

  onRegister(input: any): void {
    this.axiosService.request(
      "POST",
      "/register",
      {
        username: input.username,
        password: input.password,
        email: input.email
      }
    ).then(response => {
      this.axiosService.setAuthToken(response.data.token);
      this.showComponent("main");
    })
  }

}
