package co.kr.munjo.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTestMoon is a Querydsl query type for TestMoon
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTestMoon extends EntityPathBase<TestMoon> {

    private static final long serialVersionUID = -1788521994L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTestMoon testMoon = new QTestMoon("testMoon");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduction = createString("introduction");

    public final QAccount owner;

    public final StringPath title = createString("title");

    public QTestMoon(String variable) {
        this(TestMoon.class, forVariable(variable), INITS);
    }

    public QTestMoon(Path<? extends TestMoon> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTestMoon(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTestMoon(PathMetadata metadata, PathInits inits) {
        this(TestMoon.class, metadata, inits);
    }

    public QTestMoon(Class<? extends TestMoon> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.owner = inits.isInitialized("owner") ? new QAccount(forProperty("owner"), inits.get("owner")) : null;
    }

}

