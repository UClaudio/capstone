import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Options } from 'ngx-google-places-autocomplete/objects/options/options';
import { Restaurant } from 'src/app/models/restaurant';
import { RestaurantService } from 'src/app/services/restaurant.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  b: boolean = false
  restaurants!: Restaurant[]

  restaurants2: Restaurant[] = []
  constructor(private restSvc: RestaurantService) { }

  ngOnInit(): void {
    this.restSvc.getAll().subscribe({
      next: res => {
        this.restaurants = res;
        console.log(res)
      },
      error: error => console.log(error)
    })
  }

  options: Options = new Options({
    componentRestrictions: { country: 'IT' }
  })

  formattedAddress = ""
  handleAddressChange(address: any) {
    this.formattedAddress = address.formatted_address
  }

  distanceMatrix() {

    this.restaurants2 = []

    // initialize service
    const service = new google.maps.DistanceMatrixService();

    // build request
    const request = {
      origins: this.restaurants.map(r => r.address),
      destinations: [this.formattedAddress],
      travelMode: google.maps.TravelMode.DRIVING,
      unitSystem: google.maps.UnitSystem.METRIC,
      avoidHighways: false,
      avoidTolls: false,
    };

    // get distance matrix response
    service.getDistanceMatrix(request, (response, status) => {
      if (status != google.maps.DistanceMatrixStatus.OK) {
        alert('Error was: ' + status);
      }
      else {
        this.restaurants.forEach((r, i) => 
        response.rows[i].elements[0].distance.value < 15000 ?
        this.restaurants2.push(r) :
        this.restaurants2.splice(this.restaurants2.indexOf(r), 1))
      }

    })
  }

  showDiv() {
    this.b = !this.b
  }

}
