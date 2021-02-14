package uz.texnopos.namaz.data.firebase

import com.google.firebase.firestore.FirebaseFirestore

class FirebaseHelper{
    private val db = FirebaseFirestore.getInstance()

    fun getAllArticle(onSuccess: (List<ArticleFB?>) -> Unit,
                   onFailure: (msg: String?) -> Unit) {

        db.collection("article").get()
            .addOnSuccessListener {
                if (it.documents.isNotEmpty()) {
                    val result = it.documents.map { doc ->
                        doc.toObject(ArticleFB::class.java)
                    }
                    onSuccess.invoke(result)
                } else {
                    onSuccess.invoke(listOf())
                }
            }
            .addOnFailureListener {
                onFailure.invoke(it.localizedMessage)
            }
    }
}
