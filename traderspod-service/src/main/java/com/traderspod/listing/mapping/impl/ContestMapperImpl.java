package com.traderspod.listing.mapping.impl;

import com.traderspod.listing.domain.Contest;
import com.traderspod.listing.domain.Currency;
import com.traderspod.listing.dto.output.ContestResponse;
import com.traderspod.listing.mapping.ContestMapper;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-25T14:51:55-0400",
    comments = "version: 1.5.0.Beta2, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ContestMapperImpl implements ContestMapper {

    private final DatatypeFactory datatypeFactory;

    public ContestMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public ContestResponse contestToContestResponse(Contest contest) {
        if ( contest == null ) {
            return null;
        }

        ContestResponse contestResponse = new ContestResponse();

        contestResponse.setContestId( contest.getId() );
        contestResponse.setCurrency( contestCurrencySymbol( contest ) );
        contestResponse.setTitle( contest.getTitle() );
        contestResponse.setTradingAmount( contest.getTradingAmount() );
        contestResponse.setStartDate( xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( contest.getStartDate() ) ) );
        contestResponse.setEndDate( xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( contest.getEndDate() ) ) );
        contestResponse.setLockDate( xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( contest.getLockDate() ) ) );
        contestResponse.setDescription( contest.getDescription() );
        contestResponse.setStatus( contest.getStatus() );

        return contestResponse;
    }

    private XMLGregorianCalendar dateToXmlGregorianCalendar( Date date ) {
        if ( date == null ) {
            return null;
        }

        GregorianCalendar c = new GregorianCalendar();
        c.setTime( date );
        return datatypeFactory.newXMLGregorianCalendar( c );
    }

    private static LocalDateTime xmlGregorianCalendarToLocalDateTime( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        if ( xcal.getYear() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMonth() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getDay() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getHour() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMinute() != DatatypeConstants.FIELD_UNDEFINED
        ) {
            if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED
                && xcal.getMillisecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond(),
                    Duration.ofMillis( xcal.getMillisecond() ).getNano()
                );
            }
            else if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond()
                );
            }
            else {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute()
                );
            }
        }
        return null;
    }

    private String contestCurrencySymbol(Contest contest) {
        if ( contest == null ) {
            return null;
        }
        Currency currency = contest.getCurrency();
        if ( currency == null ) {
            return null;
        }
        String symbol = currency.getSymbol();
        if ( symbol == null ) {
            return null;
        }
        return symbol;
    }
}
