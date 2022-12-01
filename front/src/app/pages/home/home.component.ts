import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  form!: FormGroup

  address!: HTMLElement

  constructor() { }

  ngOnInit(): void {
    this.initMap()
    this.form = new FormGroup({
      address: new FormControl(null, [Validators.required])
    })
    console.log(this.address)
  }

  initMap(): void {
    // The location of Uluru
    const uluru = { lat: 45.12464318174044, lng: 8.909626336317315};
    // The map, centered at Uluru
    const map = new google.maps.Map(
      document.getElementById("map") as HTMLElement,
      {
        zoom: 14,
        center: uluru,
      }
    );
     // The marker, positioned at Uluru
    const marker = new google.maps.Marker({
      position: uluru,
      map: map,
    });

    const infowindow = new google.maps.InfoWindow();

    infowindow.setContent(this.address);
    let inp = (new HTMLInputElement()).value;

    const autocomplete = new google.maps.places.Autocomplete(this.address as HTMLInputElement);
  }
}
