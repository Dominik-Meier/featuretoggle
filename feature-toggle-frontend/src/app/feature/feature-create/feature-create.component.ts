import { NgFor } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormArray, FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { FeatureService } from '../feature.service';
import { Feature } from '../feature';

@Component({
  selector: 'app-feature-create',
  standalone: true,
  imports: [ReactiveFormsModule, NgFor],
  templateUrl: './feature-create.component.html'
})
export class FeatureCreateComponent {
  @Output() onFeatureSaved: EventEmitter<void> = new EventEmitter<void>();
  constructor(private formBuilder: FormBuilder, private featureService: FeatureService) {
  }

  featureToggleForm = this.formBuilder.group({
    displayName: [''],
    technicalName: [''],
    description: [''],
    expiresOn: [''],
    inverted: [false],
    customerIds: this.formBuilder.array([this.formBuilder.control('')]),
  })

  get customers(): FormArray {
    return this.featureToggleForm.get('customerIds') as FormArray;
  }

  onSubmit() {
    let feature = this.featureToggleForm.value as Feature;
    if(this.featureToggleForm.value.expiresOn) {
      feature.expiresOn = this.parseDate(this.featureToggleForm.value.expiresOn);
    }
    
    this.featureService.createFeature(feature).subscribe( f => 
      this.onFeatureSaved.emit()
    )
  }

  addCustomer() {
    this.customers.push(this.formBuilder.control(''));
  }

  // TODO write directive to parse inplace
  parseDate(dateString: string): Date {
    let splittedDate: string[] = dateString.split('-');
    let date = new Date();
    date.setFullYear(+splittedDate[0], +splittedDate[1]-1, +splittedDate[2])
    return date;
  }
}
