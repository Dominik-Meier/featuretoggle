import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeatureCreateComponent } from './feature-create.component';
import { FeatureService } from '../feature.service';
import { of } from 'rxjs';

describe('FeatureCreateComponent', () => {
  let component: FeatureCreateComponent;
  let fixture: ComponentFixture<FeatureCreateComponent>;

  beforeEach(async () => {
    let mockService = jasmine.createSpyObj(FeatureService, ['createFeatures']);
    mockService.createFeatures.and.returnValue(of([]));

    await TestBed.configureTestingModule({
      providers: [{provide: FeatureService, useValue: mockService}],
      imports: [FeatureCreateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FeatureCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
