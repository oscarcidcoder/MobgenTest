package com.mobgen.mobgentest.repository

import com.mobgen.mobgentest.db.dao.CategoryDAO
import com.mobgen.mobgentest.network.NetworkDataSourse

class RepositoryMobgen(private val remote: NetworkDataSourse, private val local: CategoryDAO) {
}