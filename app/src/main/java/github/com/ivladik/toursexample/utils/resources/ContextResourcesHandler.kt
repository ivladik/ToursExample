package github.com.ivladik.toursexample.utils.resources

import android.content.Context
import javax.inject.Inject

/**
 * @author Vladislav Falzan.
 */
class ContextResourcesHandler @Inject constructor(private val context: Context) : ResourcesHandler {

    override fun getString(stringRes: Int, vararg args: Any): String = context.getString(stringRes, args)

    override fun getQuantityString(pluralsRes: Int, quantity: Int, vararg formatArgs: Any): String {
        return context.resources
            .getQuantityString(pluralsRes, quantity, *formatArgs)
    }
}