package es.jlarriba.tuixo.tuils;

import androidx.core.content.FileProvider;

import es.jlarriba.tuixo.BuildConfig;

public class GenericFileProvider extends FileProvider {
    public static final String PROVIDER_NAME = BuildConfig.APPLICATION_ID + ".FILE_PROVIDER";
}
