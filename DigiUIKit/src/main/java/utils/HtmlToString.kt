package utils

import android.text.Html
import android.text.Spanned

fun convertHtmlString(htmlString: String): Spanned {
        val htmlAsString = htmlString
        val htmlAsSpanned: Spanned = Html.fromHtml(htmlAsString)
        return htmlAsSpanned
}