package daniyal.android.basewithkotlin.data.models

import com.google.gson.annotations.SerializedName

data class EmployePojo(@SerializedName("id") var id: String,
                       @SerializedName("employee_name") var employeName: String,
                       @SerializedName("employee_salary") var employeSalary: String,
                       @SerializedName("employee_age") var employeAge: String,
                       @SerializedName("profile_image") var profileImage: String
)