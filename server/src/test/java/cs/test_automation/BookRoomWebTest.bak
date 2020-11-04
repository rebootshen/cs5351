/*
 * MIT License
 *
 * Copyright (c) 2018 Elias Nogueira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package cs.test_automation;

import static org.assertj.core.api.Assertions.assertThat;

import cs.test_automation.base.BaseWeb;
import com.eliasnogueira.data.BookingDataFactory;
import com.eliasnogueira.model.Booking;
import org.testng.annotations.Test;
import com.eliasnogueira.page.booking.AccountPage;
import com.eliasnogueira.page.booking.DetailPage;
import com.eliasnogueira.page.booking.RoomPage;

public class BookRoomWebTest extends BaseWeb {

    @Test(description = "Book a room")
    public void bookARoom() {
        Booking bookingInformation = new BookingDataFactory().createBookingData();

        AccountPage accountPage = new AccountPage();
        accountPage.fillEmail(bookingInformation.getEmail());
        accountPage.fillPassword(bookingInformation.getPassword());
        accountPage.selectCountry(bookingInformation.getCountry());
        accountPage.selectBudget(bookingInformation.getDailyBudget());
        accountPage.clickNewsletter();
        accountPage.next();

        RoomPage roomPage = new RoomPage();
        roomPage.selectRoomType(bookingInformation.getRoomType());
        roomPage.next();

        DetailPage detailPage = new DetailPage();
        detailPage.fillRoomDescription(bookingInformation.getRoomDescription());
        detailPage.finish();

        assertThat(detailPage.getAlertMessage())
            .isEqualTo("Your reservation has been made and we will contact you shortly");
    }

    @Test(description = "Fill booking information")
    public void fillBookingInfo() {
        Booking bookingInformation = new BookingDataFactory().createBookingData();

        AccountPage accountPage = new AccountPage();
        accountPage.fillEmail("CS5351@cityu.edu.hk");
        accountPage.fillPassword(bookingInformation.getPassword());
        accountPage.selectCountry(bookingInformation.getCountry());
        accountPage.selectBudget(bookingInformation.getDailyBudget());
        accountPage.clickNewsletter();

        assertThat(accountPage.getEmail()).isEqualTo("CS5351@cityu.edu.hk");
    }

    @Test(description = "Switch to room type page")
    public void switchToRoomTypePage() {
        Booking bookingInformation = new BookingDataFactory().createBookingData();

        AccountPage accountPage = new AccountPage();
        accountPage.fillEmail(bookingInformation.getEmail());
        accountPage.fillPassword(bookingInformation.getPassword());
        accountPage.selectCountry(bookingInformation.getCountry());
        accountPage.selectBudget(bookingInformation.getDailyBudget());
        accountPage.clickNewsletter();
        accountPage.next();

        RoomPage roomPage = new RoomPage();

        assertThat(roomPage.getRoomTypeDescriptionMsg()).isEqualTo("What type of room would you want?");
    }

    @Test(description = "Switch to extra detail page")
    public void switchToDetailPage() {
        Booking bookingInformation = new BookingDataFactory().createBookingData();

        AccountPage accountPage = new AccountPage();
        accountPage.fillEmail(bookingInformation.getEmail());
        accountPage.fillPassword(bookingInformation.getPassword());
        accountPage.selectCountry(bookingInformation.getCountry());
        accountPage.selectBudget(bookingInformation.getDailyBudget());
        accountPage.clickNewsletter();
        accountPage.next();

        RoomPage roomPage = new RoomPage();
        roomPage.selectRoomType(bookingInformation.getRoomType());
        roomPage.next();

        DetailPage detailPage = new DetailPage();

        assertThat(detailPage.getDescriptionMsg()).isEqualTo("Drop us a small description.");
    }

    @Test(description = "Switch to previous page")
    public void switchToPreviousPage() {
        Booking bookingInformation = new BookingDataFactory().createBookingData();

        AccountPage accountPage = new AccountPage();
        accountPage.fillEmail(bookingInformation.getEmail());
        accountPage.fillPassword(bookingInformation.getPassword());
        accountPage.selectCountry(bookingInformation.getCountry());
        accountPage.selectBudget(bookingInformation.getDailyBudget());
        accountPage.clickNewsletter();
        accountPage.next();

        RoomPage roomPage = new RoomPage();
        roomPage.selectRoomType(bookingInformation.getRoomType());
        roomPage.next();

        DetailPage detailPage = new DetailPage();
        detailPage.fillRoomDescription(bookingInformation.getRoomDescription());
        detailPage.previous();

        assertThat(roomPage.isChecked(bookingInformation.getRoomType())).isEqualTo(true);
    }
}
