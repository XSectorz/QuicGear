import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StateService {

  constructor() { }

  private componentToShowSource = new BehaviorSubject<string>('login');
  componentToShow$ = this.componentToShowSource.asObservable();

  setComponentToShow(component: string): void {
    this.componentToShowSource.next(component);  
  }

  getComponentToShow(): string {
    return this.componentToShowSource.value; 
  }

}
