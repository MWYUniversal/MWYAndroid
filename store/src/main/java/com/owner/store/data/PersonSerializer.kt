package com.owner.store.data

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.owner.store.PersonPreferences
import java.io.InputStream
import java.io.OutputStream

object PersonSerializer:Serializer<PersonPreferences> {
    override val defaultValue: PersonPreferences
        get() = PersonPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): PersonPreferences {
        try {
            return PersonPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: PersonPreferences, output: OutputStream) {
        return t.writeTo(output)
    }

}
