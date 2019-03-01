package github.com.ivladik.toursexample.repository

/**
 * @author Vladislav Falzan.
 */
class RepositoryProvider private constructor() {

    companion object {

        val instance: ToursRepository by lazy {
            DefaultToursRepository()
        }
    }
}