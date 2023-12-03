package com.agent.fasttag

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.agent.fasttag.databinding.ActivityForgotPasswordBinding
import com.agent.fasttag.databinding.ActivityResetPasswordBinding
import com.agent.fasttag.view.api.RetrofitService
import com.agent.fasttag.view.model.LoginRequestJson
import com.agent.fasttag.view.util.AppConstants
import com.agent.fasttag.view.util.Status
import com.agent.fasttag.view.viewmodel.FasTagRepository
import com.agent.fasttag.view.viewmodel.FasTagViewModelFactory
import com.agent.fasttag.view.viewmodel.FastTagViewModel
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding:ActivityForgotPasswordBinding
    private var phoneNumberVal:String=""
    private var newPasswordVal:String=""
    private var confirmPasswordVal:String=""
    var retrofitService: RetrofitService? =null
    lateinit var viewModel: FastTagViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setupViewModel()
        setUpObserver()
    }
    private fun initView(){
        binding.headerLayout.ivToolBarBack.setOnClickListener {
            finish()
            AppConstants.slideToLeftAnim(this)
        }
        binding.submit.setOnClickListener {

            phoneNumberVal = binding.editPhoneNumberInput.text.toString().trim()
            newPasswordVal = binding.editNewPasswodInput.text.toString().trim()
            confirmPasswordVal = binding.editConfirmPasswordInput.text.toString().trim()

            if(phoneNumberVal == ""){
                AppConstants.showMessageAlert(this,getString(R.string.please_enter_phone_number))
            }else if(newPasswordVal == ""){
                AppConstants.showMessageAlert(this,getString(R.string.please_enter_new_password))
            }else if(confirmPasswordVal == ""){
                AppConstants.showMessageAlert(this,getString(R.string.please_enter_confirm_password))
            }else if(newPasswordVal != confirmPasswordVal){
                AppConstants.showMessageAlert(this,getString(R.string.confirm_password_validation))
            }else{
                AppConstants.launchSunsetDialog(this)
                var requestData= LoginRequestJson(phoneNumberVal,confirmPasswordVal)
                val loginRequestJsonData = Gson().toJson(requestData)
                val jsonObject = JSONObject(loginRequestJsonData)
                val request = jsonObject.toString().toRequestBody("application/json".toMediaTypeOrNull());
                println("loginRequestJsonData:: "+request)
                viewModel.agentForgotPassword(request)
            }
        }
    }
    private fun setupViewModel() {
        retrofitService = RetrofitService.getInstance(AppConstants.baseURL)
        var repository = FasTagRepository(retrofitService!!)
        viewModel = ViewModelProvider(
            this,
            FasTagViewModelFactory(repository)
        )[FastTagViewModel::class.java]
    }
    private fun setUpObserver(){
        viewModel.forgotPasswordRequest().observe(this){
            AppConstants.cancelSunsetDialog()

            println("loginRequestData:: $it")
            when(it.status){
                Status.SUCCESS ->{

                    showResponseMessageAlert(this,it.data!!.message)
                }
                Status.LOADING -> {
                    AppConstants.launchSunsetDialog(this)

                }
                Status.ERROR -> {
                    //Handle Error
                    AppConstants.cancelSunsetDialog()
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }

    }
    fun showResponseMessageAlert(mContext: Activity, message: String?) {
        mContext.runOnUiThread {
            val builder = AlertDialog.Builder(mContext)
            builder.setMessage(message)
            builder.setTitle(mContext.getString(R.string.app_name))
            builder.setCancelable(false)
            builder.setPositiveButton(
                Html.fromHtml("<font color=" + mContext.resources.getColor(R.color.colorAccent) + ">OK</font>"),
                DialogInterface.OnClickListener {
                        dialog: DialogInterface, which: Int -> dialog.dismiss()
                     if(message == "Password updated successfully"){
                         finish()
                         AppConstants.slideToLeftAnim(this)
                     }
                })
            /* builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });*/
            val alertDialog = builder.create()
            // Show the Alert Dialog box
            alertDialog.show()
        }
    }
}