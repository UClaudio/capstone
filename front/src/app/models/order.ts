import { Address } from "./address"
import { Restaurant } from "./restaurant"

export class Order {
    id: number| undefined
    pickUpPlace: Restaurant
    deliveryAddress: Address
    pickUpTime: Date
    deliveryCost: number
    status: string
    expectedDeliveryTime: Date
    productId: number[]
    userId: number

    constructor(pickUpPlace: Restaurant, deliveryAddress: Address, pickUpTime: Date, deliveryCost: number, status: string, expectedDeliveryTime: Date, productId: number[], userId: number) {
        this.pickUpPlace = pickUpPlace
        this.deliveryAddress = deliveryAddress
        this.pickUpTime = pickUpTime
        this.deliveryCost = deliveryCost
        this.status = status
        this.expectedDeliveryTime = expectedDeliveryTime
        this.productId = productId
        this.userId = userId
    }
}
