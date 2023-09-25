package com.example.nafasivibao.data

import android.app.ProgressDialog
import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.nafasivibao.R
import com.example.nafasivibao.models.Product
import com.example.nafasivibao.navigation.ROUTE_HOME
import com.example.nafasivibao.navigation.ROUTE_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class productviewmodel(var navController: NavHostController,var context:Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        // Inflate the custom layout and set it as the view for the ProgressDialog
        val customProgressDialogView = LayoutInflater.from(context).inflate(R.layout.custom_loading_dialog, null)
        progress.setView(customProgressDialogView)
        progress.setMessage("Please Wait...")
        progress.show()
        progress.setCancelable(false)
    }


    fun saveProduct(productName: String, productCompany: String, productLocation: String, productTime:String, productResponsibilities:String,  productSkills:String, productDocs:String, productDeadline:String) {
        var id = System.currentTimeMillis().toString()
        var productData = Product(productName, productCompany, productLocation,productTime,productResponsibilities,productSkills,productDocs,productDeadline,id)
        var productRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        productRef.setValue(productData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUTE_HOME)
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


    fun viewProducts(
        product: MutableState<Product>,
        products: SnapshotStateList<Product>
    ): SnapshotStateList<Product> {
        var ref = FirebaseDatabase.getInstance().getReference().child("Products")
        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                products.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Product::class.java)
                    product.value = value!!
                    products.add(value)
                }
                progress.dismiss()
            }


            override fun onCancelled(error: DatabaseError) {
                progress.dismiss()
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return products
    }

    fun deleteProduct(id: String) {
        var delRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Posting deleted", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUTE_HOME)
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateProduct(name: String, company: String, location: String,time:String,responsibilities:String ,skills:String, docs:String,deadline:String, id: String) {
        var updateRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        var updateData = Product(name,company,location,time,responsibilities,skills,docs,deadline, id)
        updateRef.setValue(updateData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Updating successful", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUTE_HOME)
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}