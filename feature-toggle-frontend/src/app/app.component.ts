import { Component } from '@angular/core';
import { FeatureCreateComponent } from './feature/feature-create/feature-create.component';
import { FeatureListComponent } from './feature/feature-list/feature-list.component';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FeatureCreateComponent, FeatureListComponent, NgIf],
  templateUrl: './app.component.html'
})
export class AppComponent {
  showCreate: boolean;
  showList: boolean;
  
  constructor() {}

  title = 'Feature toggle App';

  onListButtonClick() {
    this.showCreate = false;
    this.showList = true;
  }

  onCreateButtonClick() {
    this.showCreate = true;
    this.showList = false;
  }

  onFeatureSaved() {
    this.showCreate = false;
  }
}
