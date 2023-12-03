package com.agent.fasttag.view.model

data class GenerateOTPJson (

    val mobileNumber: String,
    val entityId: String="",
    val businessType: String="",
    val entityType: String=""
)
data class LoginRequestJson(

    val PhoneNumber:String,
    val Password:String,
)
data class ForgotPasswordRequestJson(

    val PhoneNumber:String,
    val Password:String,
)
data class ResetPasswordRequestJson(

    val MobileNumber:String,
    val CurrentPassword:String,
    val Password:String,
    val ConfirmPassword:String,
)
data class CreateAgentRequestJson(

    val UserName:String,
    val ParentId:String,
    val RoleId:String,
    val Password:String,
    val PhoneNumber:String,
    val FirstName:String,
    val LastName:String,
    val Email:String,
    val RoleName:String,

    )
data class GetAgentsByIdRequestJson(

    val AgentId:String,
    val ParentId:String,
    )
data class DeleteCustomerRequestJson(

    val CustomerId:String,
)
data class UpdateCustomerRequestJson(

    val AgentId:String,
    val Name:String,
    val Email:String,
    val PhoneNumber:String,
    val Gender:String,
    val Pincode:String,
    val State:String,
    val Country:String,
    val EntityType:String,
    val EntityId:String,
    val KycReferenceNumber:String,
    val DateOfBirth:String,
    val Address:String,
    val DocumentType:String,
    val DocumentNumber:String,
    val KycToken:String,
    val KycStatus:String,
    val KitNo:String,
    val KitId:String,
    val VehicleNumber:String,
    val FastTagId:String,
    val VehicleId:String,
    val Status:String,
    val CustomerId:String,
    val isAdditionalVehicle:Boolean=false
    )
data class CreateCustomerRequestJson(

    val AgentId:String,
    val Name:String,
    val Email:String,
    val PhoneNumber:String,
    val Gender:String,
    val Pincode:String,
    val State:String,
    val Country:String,
    val EntityType:String,
    val EntityId:String,
    val KycReferenceNumber:String,
    val DateOfBirth:String,
    val Address:String,
    val DocumentType:String,
    val DocumentNumber:String,
    val KycToken:String,
    val KycStatus:String,
    val KitNo:String,
    val KitId:String,
    val VehicleNumber:String,
    val FastTagId:String,
    val VehicleId:String,
    val Status:String,
    val isAdditionalVehicle:Boolean=false
)
data class CustomerDetailsByIdReequest(

    val Mobile:String?
    )