package com.sriharilabs;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-15T14:20:16+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class SourceTargetMapperImpl implements SourceTargetMapper {

    @Override
    public Target sourceToTarget(Source source) {
        if ( source == null ) {
            return null;
        }

        Target target = new Target();

        if ( source.getBaz() != null ) {
            target.setQax( source.getBaz().intValue() );
        }
        target.setBaz( (long) source.getQax() );
        target.setFoo( (long) source.getFoo() );
        if ( source.getBar() != null ) {
            target.setBar( source.getBar().intValue() );
        }
        target.setZip( String.valueOf( source.getZip() ) );

        return target;
    }

    @Override
    public Source targetToSource(Target target) {
        if ( target == null ) {
            return null;
        }

        Source source = new Source();

        if ( target.getBaz() != null ) {
            source.setQax( target.getBaz().intValue() );
        }
        source.setBaz( (long) target.getQax() );
        if ( target.getFoo() != null ) {
            source.setFoo( target.getFoo().intValue() );
        }
        source.setBar( (long) target.getBar() );
        if ( target.getZip() != null ) {
            source.setZip( Integer.parseInt( target.getZip() ) );
        }

        return source;
    }
}
