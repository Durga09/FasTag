package com.agent.fasttag.view.model

data class LoginResponse(

    val code:Int?,
    val message:String?,
    val reponseData:ReponseData?,

)

data class SaveOrEditAgentResponse(
    val code:Int?,
    val message:String?,
    val reponseData:ReponseData?,
)
data class ReponseData(

    val agentId:String,
    val parentId:String,
    val userName:String,
    val password:String="",
    val email:String,
    val phoneNumber:String,
    val firstName:String,
    val lastName:String,
    val roleId:String,
    val roleName:String,
    )
data class RollsData(
    val code:Int?,
    val message:String?,
    val reponseData:ArrayList<RollSResponseData>,

)
data class RollSResponseData(

    val roleId:String,
    val roleName:String,
)
data class TeamLeadsResponseData(

    val code:Int?,
    val message:String?,
    val reponseData:ArrayList<ReponseData>,
)
data class CustomerCreateResponseData(

    val code:Int?,
    val message:String?,
    val reponseData:CustomerCreateInternalResponseData,
)
data class CustomerDeleteResponseData(

    val code:Int?,
    val message:String?,
    val reponseData:String,
)
data class CustomerCreateInternalResponseData(
    val customerId:String?,
    val agentId:String?,
    val name:String?,
    val email:String?,
    val phoneNumber:String?,
    val entityId:String?,
    val kycReferenceNumber:String?,
    val password:String?,
    val dateOfBirth:String?,
    val address:String?,
    val documentType:String?,
    val documentNumber:String?,
    val kycToken:String?,
    val kycStatus:String?,
    val entityType:String?,
    val gender:String?,
    val pincode:String?,
    val state:String?,
    val country:String?,
    val vehicleData:ArrayList<VehicleData>,
    val fastTagData:ArrayList<FastTagData?>,

    )
 data class VehicleData(
     val vehicleId:String?,
     val vehicleNumber:String?,

     )
data class FastTagData(
    val fastTagId:String?,
    val kitNo:String?,
    val kitId:String?,
    val status:String?,

    )