package org.simplon.epec.archivage.domain.document.repository;

import org.simplon.epec.archivage.domain.document.entity.Context;

public interface ContextRepository {

    Context createContext(Context context);
    Context saveContext(Context context);
}
