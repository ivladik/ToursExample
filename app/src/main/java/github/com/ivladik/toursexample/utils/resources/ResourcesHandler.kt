package github.com.ivladik.toursexample.utils.resources

import android.content.res.Resources
import android.support.annotation.PluralsRes
import android.support.annotation.StringRes

/**
 * @author Vladislav Falzan.
 */
interface ResourcesHandler {

    fun getString(@StringRes stringRes: Int, vararg args: Any): String

    @Throws(Resources.NotFoundException::class)
    fun getQuantityString(@PluralsRes pluralsRes: Int, quantity: Int, vararg formatArgs: Any): String
}